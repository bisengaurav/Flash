<template>
    <div>

        <div class="z-level4" :class="{'nav-expanded': isOpen}">
            <div class="slds-backdrop" @click="close"></div>

            <div class="nav-panel">
                <div class="logo">
                    <img alt="Cervello" src="/assets/img/logo-white.png" />
                </div>

                <div class="nav">
                    <router-link :to="{name: 'home'}" exact active-class="nav-active" @click="close">Home</router-link>
                    <router-link :to="{name: 'users'}" active-class="nav-active" @click="close">User Management</router-link>
                    <router-link :to="{name: 'callouts'}" active-class="nav-active" @click="close">Callouts</router-link>
                    <router-link :to="{name: 'equipment'}" active-class="nav-active" @click="close">Equipment</router-link>
                    <router-link :to="{name: 'serviceResources'}" active-class="nav-active" @click="close">Service Resources</router-link>

                    <div class="nav-user">
                        <a @click="clearCache">
                            <icon icon="trash-alt" class="slds-icon slds-icon_xx-small slds-m-right_x-small" />
                            <span>Clear All Cache</span>
                        </a>
                        <a href="/logout">
                            <icon icon="key" class="slds-icon slds-icon_xx-small slds-m-right_x-small" />
                            <span>Logout</span>
                        </a>
                    </div>
                </div>
            </div>

            <div class="nav-sign" @click="open">
                <icon icon="bars" class="slds-icon" />
            </div>
        </div>

        <div class="main-scroll">
            <div class="main" popover-boundary>
                <slot></slot>
            </div>
        </div>

    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faBars, faTrashAlt, faKey} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faBars, faTrashAlt, faKey);

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
            },
            clearCache() {
                this.$ls.clear();
                location.reload();
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
    html,
    body {
        overflow: hidden;
    }
    .main-scroll {
        height: 100vh;
        /*overflow: hidden;*/
        overflow-y: auto;
    }
    .main {
        padding: 30px 40px;
        margin-left: 90px;
    }


    /* Nav Sign */

    .nav-sign {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 90px;
        background-color: #0071b9;
    }
    .nav-sign .slds-icon {
        position: absolute;
        top: 40px;
        left: 31px;
        width: 30px;
        text-align: center;

        fill: #fff;
        cursor: pointer;
    }


    /* Nav Panel - Logo + Nav */

    .nav-panel {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 90px;
        background-color: #0071b9;
        transition: width 0.5s;
    }


    /* Logo */

    .logo {
        position: absolute;
        left: -200px;
        top: 40px;

        z-index: 2;
        background-color: #0071b9;
        opacity: 0;
    }
    .logo,
    .logo img {
        width: 113px;
        height: 57px;
    }


    /* Nav */

    .nav {
        position: absolute;
        top: 138px;
        left: -400px;
        bottom: 0;
        width: 100%;
        overflow: hidden;
        overflow-y: auto;
        opacity: 0;
    }
    .nav a {
        display: block;
        padding: 0 30px;
        height: 42px;

        font-size: 12px;
        font-weight: 700;
        line-height: 42px;
        color: #fff;
        text-decoration: none;
        text-transform: uppercase;
    }
    .nav a:hover {
        background-color: #057ac4;
    }
    .nav a.nav-active,
    .nav a.nav-active:hover {
        color: #fff;
        background-color: #1990dc;
    }

    .nav-user {
        margin-top: 10px;
        padding-top: 10px;
        border-top: 1px solid #057cc8;
    }
    .nav-user a {
        text-transform: none;
    }


    /* Expand */

    .nav-expanded .slds-backdrop {
        visibility: visible;
        opacity: 1;
        transition: opacity 0.4s linear;
    }
    .nav-expanded .nav-panel {
        width: 220px;
        border: none;
        box-shadow: 1px 0 4px rgba(0,0,0,.3);
    }
    .nav-expanded .nav-sign {
        display:none;
    }
    .nav-expanded .logo {
        left: 31px;
        opacity: 1;
        transition: opacity 0.5s;
        transition-delay: 0.3s
    }
    .nav-expanded .nav {
        left: 0;
        opacity: 1;
        transition: opacity 0.5s;
        transition-delay: 0.3s
    }



    @media (max-width: 479px) {
        .main {
            padding: 60px 20px 20px;
            margin-left: 0;
        }


        /* Nav Sign */

        .nav-sign {
            height: 40px;
            width: 100%;
        }
        .nav-sign .slds-icon {
            position: absolute;
            top: 4px;
            left: 50%;
            transform: translateX(-50%);

            width: 28px;
        }


        /* Nav Panel - Logo + Nav */

        .nav-panel {
            width: 0;
            border-right: none;
        }

    }

</style>
