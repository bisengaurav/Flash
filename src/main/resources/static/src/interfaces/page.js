import {CLEAR} from '../components/alert-emitter/events';

export default {
    //
    // PARAMS: props, data, computed
    //
    data() {
        return  {
            pageTitle: ''
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
