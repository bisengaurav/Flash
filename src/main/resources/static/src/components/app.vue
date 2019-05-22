<template>
    <div>
        <navigation>
            <router-view></router-view>
        </navigation>

        <alert-emitter />
        <page-loader />
    </div>
</template>

<script>
    import Navigation from './navigation.vue';
    import PageLoader from './page-loader';
    import AlertEmitter from './alert-emitter';

    export default {
        //
        // LOCAL COMPONENTS
        //
        components: {
            Navigation,
            PageLoader,
            AlertEmitter
        }
    }
</script>
