<script>
    import SelectLoader from './select-loader.vue';

    export default {
        extends: SelectLoader,

        //
        // PARAMS: porps, data, computed
        //
        props: {
            all: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                innerSource: (this.$props.all ? this.$API.objectConfig.getAllSfObjectsNames : this.$API.archiverConfig.getSupportedSfObjects)
            }
        },

        //
        // METHODS
        //
        methods: {
            getValue: function(option) {
                return option.apiName;
            },
            getLabel: function(option) {
                return option.apiName +' ('+ option.label +')';
            }
        }
    }
</script>
