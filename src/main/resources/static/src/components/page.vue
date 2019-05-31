<script>
    import {CLEAR} from '../components/alert-emitter/events';

    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return  {
                pageTitle: 'Title'
            }
        },

        //
        // EVENTS
        //
        mounted() {
            this.$EM.$emit(CLEAR);
        },

        //
        // WATCHERS
        //
        watch: {
            pageTitle: {
                handler: function() {
                    document.title = this.pageTitle;
                },
                immediate: true
            }
        }
    }
</script>
