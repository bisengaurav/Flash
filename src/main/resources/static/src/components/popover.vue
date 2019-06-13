<template>
    <span>

        <span
            ref="popover"
            v-show="isShow"
            class="popover"
            :style="{
                maxWidth: ($props.maxWidth ? $props.maxWidth+'px' : 'none')
            }"
        >
            <slot name="content"></slot>
        </span>

        <slot></slot>

    </span>
</template>

<script>
    import Popper from 'popper.js';

    function on(element, event, handler) {
        if (element && event && handler) {
            document.addEventListener ? element.addEventListener(event, handler, false) : element.attachEvent('on' + event, handler);
        }
    }
    function off(element, event, handler) {
        if (element && event) {
            document.removeEventListener ? element.removeEventListener(event, handler, false) : element.detachEvent('on' + event, handler)
        }
    }

    function elementContains(elm, otherElm) {
        if (typeof elm.contains === 'function') {
            return elm.contains(otherElm);
        }
        return false;
    }


    /* Events:
    *
    * SHOW
    * HIDE
    * CREATED
    * DOCUMENT_CLICK
    *
    * */

    export default {
        //
        // PARAMS: props, data, computed
        //
        props: {
            trigger: {
                type: String
            },
            position: {
                type: String
            },
            offset: {
                type: Number,
            },

            maxWidth: {
                default: null
            }
        },
        data() {
            return {
                isShow: false,
                popperJS: null,
                timeout: null,

                defaultTrigger: 'click',
                defaultPosition: 'bottom',
                defaultOffset: 0
            };
        },
        computed: {
            targetElm() {
//                return this.$refs.target;
                return this.$slots.default[0].elm;
            },
            popoverElm() {
                return this.$refs.popover;
            },

            computedTrigger() {
                return this.$props.trigger || this.defaultTrigger;
            },
            computedPosition() {
                let p = this.$props.position || this.defaultPosition;
                return Popper.placements.includes(p) ? p : Popper.placements[0];
            },
            computedOffset() {
                return (this.$props.offset && this.$props.offset !== 0 ? this.$props.offset : this.defaultOffset);
            },

            delay() {
                return (this.computedTrigger == 'hover' ? 300 : 50);
            },
        },

        //
        // EVENTS
        //
        mounted() {
            switch(this.computedTrigger) {
                case 'hover':
                    on(this.targetElm, 'mouseover', this.show);
                    on(this.targetElm, 'mouseout', this.hide);
                    break;

                case 'focus':
                    on(this.targetElm, 'focus', this.show);
                    on(document, 'click', this.handleDocumentClick);
                    break;

                case 'click':
                default:
                    on(this.targetElm, 'click', this.toggle);
                    on(document, 'click', this.handleDocumentClick);
                    break;
            }
        },

        destroyed() {
            switch(this.computedTrigger) {
                case 'hover':
                    off(this.targetElm, 'mouseover', this.show);
                    off(this.targetElm, 'mouseout', this.hide);
                    break;

                case 'focus':
                    off(this.targetElm, 'focus', this.show);
                    off(document, 'click', this.handleDocumentClick);
                    break;

                case 'click':
                default:
                    off(this.targetElm, 'click', this.toggle);
                    off(document, 'click', this.handleDocumentClick);
                    break;
            }

            this.isShow = false;

            if (this.popperJS) {
                this.popperJS.destroy();
                this.popperJS = null;
            }
        },

        //
        // WATCHERS
        //
        watch: {
            isShow(value) {
                if (value) {
                    if (this.popperJS) this.popperJS.enableEventListeners();
                    this.$emit('SHOW', this);
                    this.update();

                } else {
                    if (this.popperJS) this.popperJS.disableEventListeners();
                    this.$emit('HIDE', this);
                }
            }
        },

        //
        // METHODS
        //
        methods: {
            update() {
                if (this.popperJS) {
                    this.popperJS.scheduleUpdate();

                } else {
                    this.$nextTick(() => {
                        this.popperJS = new Popper(
                            this.targetElm,
                            this.popoverElm,
                            {
                                placement: this.computedPosition,
                                removeOnDestroy: true,
                                positionFixed: true,
                                modifiers: {
                                    computeStyle: {
                                        gpuAcceleration: false
                                    },
                                    offset: {
                                        offset: [
                                            this.computedOffset
                                        ].reduce((r, c) => r.concat([c, c]), []).join(',')
                                    },
                                    preventOverflow: {
                                        boundariesElement: document.querySelector('[popover-boundary]')
                                    }
                                },
                                onCreate: () => {
                                    this.$emit('CREATED', this);
                                    this.$nextTick(this.update);
                                }
                            }
                        );
                    });
                }
            },

            show() {
                clearTimeout(this.timeout);
                this.timeout = setTimeout(() => {
                    this.isShow = true;
                }, this.delay);
            },

            hide() {
                clearTimeout(this.timeout);
                this.timeout = setTimeout(() => {
                    this.isShow = false;
                }, 50);
            },

            toggle() {
                if (this.isShow)
                    this.hide();
                else
                    this.show();
            },

            handleDocumentClick(e) {
                if (
                    !this.$el ||
                    !this.targetElm ||
                    !this.popoverElm ||
                    elementContains(this.$el, e.target) ||
                    elementContains(this.targetElm, e.target) ||
                    elementContains(this.popoverElm, e.target)
                ) {
                    return;
                }

                this.$emit('DOCUMENT_CLICK', this);
                this.hide();
            }

        }
    }
</script>

<style>
    .popover {
        position: absolute;
        display: block;
        width: auto;
        z-index: 1000;
    }
</style>
