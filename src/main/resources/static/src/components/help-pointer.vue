<template>
    <span>
        <tooltip v-if="$props.content" :content="$props.content" maxWidth="300">
            <icon icon="info-circle" class="slds-icon slds-icon_xx-small slds-icon-text-light" />
        </tooltip>
    </span>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faInfoCircle} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faInfoCircle);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            content: {
                type: String,
                default: ''
            }
        },

    }
</script>
