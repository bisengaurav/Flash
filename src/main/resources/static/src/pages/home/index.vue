<template>
    <section>
        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <div class="home-page_wrapper" v-html="$t('text.home.html')" />
    </section>
</template>

<script>
    import PageInterface from '../../interfaces/page.js';

    export default {
        extends: PageInterface,
        //
        // PARAMS: props, data, computed
        //
        data() {
            return {
                pageTitle: this.$t('text.home.page-title')
            }
        }
    }
</script>

<style scoped>
    .home-page_wrapper >>> h2 {
        font-size: .95rem;
        font-weight: 700;
    }
    .home-page_wrapper >>> ul {
        margin-left: 1.5rem;
        list-style: disc;
    }
</style>
