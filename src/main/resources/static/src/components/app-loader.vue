<template>
    <div class="app-loader slds-grid slds-grid_vertical-align-center slds-grid_align-center">
        <div class="slds-text-align_center">
            <div class="app-loader_logo">
                <img alt="" src="/static/img/logo-large.png" />
            </div>

            <spinner class="app-loader_spinner" />
        </div>
    </div>
</template>

<script>
    export default {}
</script>

<style scoped>
    .app-loader {
        position: fixed;
        width: 100%;
        height: 100%;
    }
    .app-loader_logo {
        width: 195px;
        height: 100px;
    }
    .app-loader_spinner {
        height: 3rem;
        width: 3rem;
        margin-top: 50px;
        fill: #86c2e6;
    }
</style>
