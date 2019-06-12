import PageInterface from './page.js';

export default {
    extends: PageInterface,

    //
    // PARAMS: props, data, computed
    //
    props: {
        id: {
            type: Number,
            default: null
        }
    },
    data() {
        return  {
            loading: true,
            titleField: 'name',

            action: null,
            data: null
        }
    },

    //
    // METHODS
    //
    methods: {
        init() {
            this.loading = true;

            // wrong Job ID
            if (!this.id) {
                throw new Error('Wrong ID');
            }

            // data
            this.action(this.id)
                .then(data => {
                    this.loading = false;
                    this.data = data;

                    this.pageTitle = this.data[this.titleField];
                })
                .catch(() => {
                    this.loading = false;
                });
        }
    },

    //
    // WATCHERS
    //
    watch: {
        id: {
            handler() {
                this.init();
            },
            immediate: true
        }
    }

}
