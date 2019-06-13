<script>
    import SelectLoader from './select-loader.vue';

    export default {
        extends: SelectLoader,

        //
        // PARAMS: props, data, computed
        //
        props: {
            trueLabel: {
                type: String
            },
            falseLabel: {
                type: String
            }
        },
        data() {
            return {
                innerSource: [
                    {
                        label: this.$props.trueLabel || this.$t('label.select-option.true'),
                        value: true
                    },
                    {
                        label: this.$props.falseLabel || this.$t('label.select-option.false'),
                        value: false
                    }
                ]
            }
        }
    }
</script>
