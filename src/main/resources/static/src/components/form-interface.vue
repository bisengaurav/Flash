<template></template>

<script>
    import {PUSH} from '../components/alert-emitter/events';

    /* Events:
    *
    * SAVED
    *
    * */

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            id: {
                default: null
            }
        },
        data() {
            return {
                loading: true,

                allowProperty: true,

                model: {},
                metadata: {},
                source: null,

                getAction: null,
                saveAction: null,

                successMessage: this.$t('message.common.data-saved')
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.loading = true;

                if (!this.beforeInit()) return;

                if ((this.allowProperty && this.id) || !this.allowProperty) {
                    // data to edit
                    this.getAction(this.id)
                        .then(data => {
                            this.loading = false;
                            this.model = Object.assign({}, this.metadata, this.filterByMetadata(this.processDataAfterLoad(data)));
                            this.source = data;
                        });
                } else {
                    // default data
                    this.loading = false;
                    this.model = Object.assign({}, this.metadata);
                }
            },
            reset() {
                this.model = Object.assign({}, this.metadata);
            },
            save() {
                if (!this.beforeSave()) return;

                this.saveAction(this.processDataBeforeSave(this.model))
                    .then(data => {
                        this.afterSave(data);
                    });
            },


            filterByMetadata(data) {
                let r = {};

                Object.keys(data).forEach(k => {
                    if (this.metadata.hasOwnProperty(k)) r[k] = data[k];
                });

                return r;
            },

            processDataAfterLoad(data) {
                return data;
            },
            processDataBeforeSave(data) {
                return data;
            },

            beforeInit() {
                // prevent initialization if some input params are wrong
                return true;
            },
            beforeSave() {
                // prevent action, if button enabled - force validate all fields
                if (this.$v !== undefined) {
                    this.$v.$touch();
                    return !this.$v.$invalid;
                } else {
                    return true;
                }
            },
            afterSave(data) {
                // fire success alert
                this.$EM.$emit(PUSH, {
                    type: 'success',
                    message: this.successMessage
                });

                // fire event on the component
                this.$emit('SAVED', data);
            }
        },

        //
        // EVENTS
        //
        mounted() {
            this.init();
        },

        //
        // WATCHERS
        //
        watch: {
            id: 'init'
        }
    }
</script>
