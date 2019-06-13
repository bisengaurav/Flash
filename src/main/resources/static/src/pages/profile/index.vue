<template>
    <div>
        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <loader :loading="loading" type="block" :height="400" #content>
            <grid class="slds-container_small">
                <grid-item x="2">
                    <form-element-static :label="$t('entity.User.name.label')">{{data.user.name}}</form-element-static>
                </grid-item>

                <grid-item x="2">
                    <form-element-static :label="$t('entity.User.profileId.label')">{{data.user.profileId}}</form-element-static>
                </grid-item>

                <grid-item x="2">
                    <form-element-static :label="$t('entity.User.timezoneSidKey.label')">{{data.user.timezoneSidKey}}</form-element-static>
                </grid-item>

                <grid-item x="2">
                    <form-element-static :label="$t('entity.User.languageLocaleKey.label')">{{data.user.languageLocaleKey}}</form-element-static>
                </grid-item>

                <grid-item x="2">
                    <form-element-static :label="$t('entity.User.isAdmin.label')">{{data.isAdmin|yesNo}}</form-element-static>
                </grid-item>
            </grid>
        </loader>

    </div>
</template>

<script>
    import PageInterface from '../../interfaces/page.js';

    export default {
        extends: PageInterface,

        data() {
            return {
                pageTitle: this.$t('text.profile.page-title'),
                data: {},
                loading: true,
            }
        },

        created() {
            this.$API.user.getUserInfo()
                .then(data => {
                    this.loading = false;
                    this.data = data;
                });
        }
    }
</script>
