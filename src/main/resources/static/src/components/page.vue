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
            document.title = this.pageTitle;

            this.$EM.$emit(CLEAR);
        }
    }
</script>
