<script>
    import SelectLoader from './select-loader.vue';

    export default {
        extends: SelectLoader,

        //
        // PARAMS: porps, data, computed
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
                        label: this.$props.trueLabel || this.$t('label.common.true'),
                        value: true
                    },
                    {
                        label: this.$props.falseLabel || this.$t('label.common.false'),
                        value: false
                    }
                ]
            }
        }
    }
</script>
