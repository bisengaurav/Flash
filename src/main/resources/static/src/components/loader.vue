<template>
    <div v-if="$props.loading" :class="preset.class" :style="preset.style">
        <spinner :class="preset.spinnerClass" />
    </div>

    <div v-else><slot name="content"></slot></div>
</template>

<script>
    export default {
        //
        // PARAMS: props, data, computed
        //
        props: {
            type: {
                type: String
            },
            loading: {
                type: Boolean,
                default: true
            },
            height: {
                type: Number,
                default: 150
            }
        },
        data() {
            return {
                presets: new Map([
                    ['block', {
                        'class': 'slds-grid slds-grid_vertical-align-center slds-grid_align-center',
                        'spinnerClass': 'slds-icon_small',
                        'style': 'height: '+ this.height +'px'
                    }],
                    ['input', {
                        'class': 'slds-input slds-grid slds-grid_vertical-align-center slds-grid_align-center loader-control',
                        'spinnerClass': 'slds-icon_xx-small loader-control-spinner',
                        'style': ''
                    }],
                    ['textarea', {
                        'class': 'slds-textarea slds-grid slds-grid_vertical-align-center slds-grid_align-center loader-control',
                        'spinnerClass': 'slds-icon_xx-small loader-control-spinner',
                        'style': 'height: '+ this.height +'px'
                    }]
                ]),
                defaultType: 'block'
            }
        },
        computed: {
            preset: function() {
                return this.presets.has(this.type) ? this.presets.get(this.type) : this.presets.values().next().value;
            }
        }
    }
</script>

<style>
    .loader-control {
        background-color: #f2f2f3;
    }
    .loader-control .loader-control-spinner {
        fill: #b0adab;
    }
</style>
