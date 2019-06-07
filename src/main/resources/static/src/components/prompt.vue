<template>
    <div>
        <modal v-if="showModal" :hideHeader="true" size="small">
            <div class="slds-p-around_medium slds-m-top_xx-small slds-text-align_center">
                <div v-html="message"></div>
                <div class="slds-p-top_medium slds-m-top_medium">
                    <button @click="showModal = false" class="slds-button slds-button_neutral">Cancel</button>
                    <button @click="_resolve" class="slds-button slds-button_brand">Ok</button>
                </div>
            </div>
        </modal>
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return  {
                message: '',
                showModal: false,
                resolver: null
            }
        },

        //
        // METHODS
        //
        methods: {
            show(message) {
                this.message = message;

                return new Promise((resolve, reject) => {
                    this.resolver = resolve;
                    this.showModal = true;
                });
            },
            _resolve() {
                this.showModal = false;
                this.resolver();
            }
        },

        //
        // INSTALL
        //
        install(Vue) {
            // create component from this instance
            let Prompt = Vue.extend(this);

            // register global component
            Vue.component('Prompt', Prompt);

            // add DIV to BODY and render component
            let div = document.createElement('div');
            document.querySelector('body').appendChild(div);
            let p = new Prompt().$mount(div);

            // register global method
            Vue.prototype.$prompt = p.show;
        }
    }
</script>
