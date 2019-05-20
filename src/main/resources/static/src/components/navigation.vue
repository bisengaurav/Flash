<template>
    <div class="z-level4">
        <div class="slds-backdrop" :class="{'slds-backdrop_open': isOpen}" @click="close"></div>

        <div class="header" :class="{'header-expanded': isOpen}" @click="open">
            <div class="logo logo-sign">
                <img alt="Cervello" src="/assets/img/logo-sign.png" />
            </div>
            <div class="logo logo-full">
                <img alt="Cervello" src="/assets/img/logo-full.png" />
            </div>

            <div class="nav-sign">
                <icon icon="bars" class="slds-icon" />
            </div>
            <div class="nav" @click.stop>
                <router-link :to="{name: 'home'}" exact active-class="active" @click="close">Home</router-link>
                <router-link :to="{name: 'users'}" active-class="active" @click="close">User Management</router-link>
                <router-link :to="{name: 'callouts'}" active-class="active" @click="close">Callouts</router-link>
                <router-link :to="{name: 'equipment'}" active-class="active" @click="close">Equipment</router-link>
                <router-link :to="{name: 'serviceResources'}" active-class="active" @click="close">Service Resource</router-link>
            </div>


            <!--div class="userinfo">
                <div class="userinfo-icon">
                    <icon icon="user-alt" class="slds-icon slds-icon_xx-small" />
                </div>
                <div class="userinfo-menu">
                    <div>
                        <div class="userinfo-username">user-name</div>
                        <a href="/">Settings</a>
                        <a href="/logout">Logout</a>
                    </div>
                    <div>
                        <a href="/login">Sign In</a>
                    </div>
                </div>
            </div-->
        </div>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faBars, faUserAlt} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faBars, faUserAlt);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                isOpen: false
            }
        },

        //
        // METHODS
        //
        methods: {
            open() {
                if (!this.isOpen) this.isOpen = true;
            },
            close() {
                this.isOpen = false;
            }
        },

        //
        // EVENTS
        //
        mounted() {
            this.$router.afterEach((to, from) => {
                this.close();
            })
        }
    }
</script>

<style>
    /*
    * Header
    */

    .header {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 90px;
        z-index: 9050;
        background-color: #182a2f;
        transition: width 0.5s;
    }
    .header-expanded {
        width: 280px;
    }



    /* Logo */

    .logo {
        position: absolute;
        left: 24px;
        top: 40px;
    }
    .logo-sign {
        z-index: 1;
    }
    .logo-sign,
    .logo-sign img {
        width: 45px;
        height: 47px;
    }

    .logo-full {
        z-index: 2;
        background-color: #182a2f;

        left: -400px;
        opacity: 0;
    }
    .header.header-expanded .logo-full {
        left: 24px;
        opacity: 1;
        transition: opacity 0.5s;
        transition-delay: 0.3s
    }
    .logo-full,
    .logo-full img {
        width: 194px;
        height: 63px;
    }


    /* Nav */

    .nav-sign {
        position: absolute;
        top: 130px;
        left: 31px;
        width: 30px;
        text-align: center;
    }
    .header.header-expanded .nav-sign {
        display:none;
    }
    .nav-sign .slds-icon {
        fill: #e3ebed;
        cursor: pointer;
    }


    .nav {
        position: absolute;
        top: 145px;
        left: -400px;
        width: 100%;
        opacity: 0;
    }
    .header.header-expanded .nav {
        left: 0;
        opacity: 1;
        transition: opacity 0.5s;
        transition-delay: 0.3s
    }

    .nav a {
        display: block;
        padding: 0 30px;
        height: 42px;

        font-size: 14px;
        line-height: 42px;
        color: #e3ebed;
        text-decoration: none;
    }
    .nav a:hover {
        color: #fff;
        background-color: #20353b;
    }
    .nav a.active,
    .nav a.active:hover {
        color: #444;
        background-color: #e3ebed;
    }


    /* UserInfo */

    .userinfo {
        position: absolute;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 145px;
        border-top: 1px solid #3f5964;
    }
    .userinfo-icon {
        position: absolute;
        top: 25px;
        left: 28px;

        width: 30px;
        height: 30px;
        background-color: #e71c50;
        border-radius: 50%;
        text-align: center;
    }
    .userinfo-icon .slds-icon {
        margin-top: 8px;
        fill: #fff;
        cursor: pointer;
    }

    .userinfo-menu {
        position: absolute;
        left: -400px;
        top: 28px;
        opacity: 0;

        font-size: 14px;
    }
    .header.header-expanded .userinfo-menu {
        left: 75px;
        opacity: 1;
        transition: opacity 0.5s;
        transition-delay: 0.3s
    }

    .userinfo-username {
        margin-bottom: 15px;
        color: #fff;
    }
    .userinfo-menu a {
        display: block;
        font-size: .8rem;
        color: #e3ebed;
    }
    .userinfo-menu a + a {
        margin-top: 5px;
    }
</style>
