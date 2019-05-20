<template>
    <div class="cmp-app_main-scroll">
        <navigation />

        <div class="cmp-app_main">
            <router-view></router-view>
        </div>

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

<style>
    html,
    body {
        background: #e6eef0;
        overflow: hidden;
    }

    .cmp-app_main-scroll {
        height: 100vh;
        overflow: hidden;
        overflow-y: auto;
    }
    .cmp-app_main {
        padding: 40px 50px;
        margin-left: 90px;
    }
</style>
