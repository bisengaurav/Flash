<template>
    <div :class="preset.class" :style="preset.style">
        <spinner :class="preset.spinnerClass" />
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            type: {
                type: String
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
                        'class': 'slds-input slds-grid slds-grid_vertical-align-center slds-grid_align-center cmp-loader-control',
                        'spinnerClass': 'slds-icon_xx-small cmp-loader-control-spinner',
                        'style': ''
                    }],
                    ['textarea', {
                        'class': 'slds-textarea slds-grid slds-grid_vertical-align-center slds-grid_align-center cmp-loader-control',
                        'spinnerClass': 'slds-icon_xx-small cmp-loader-control-spinner',
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
    .cmp-loader-control {
        background-color: #f2f2f3;
    }
    .cmp-loader-control .cmp-loader-control-spinner {
        fill: #b0adab;
    }
</style>
