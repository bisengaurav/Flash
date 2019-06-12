<template functional>
    <span v-if="props.type == 'text'">{{props.value}}</span>

    <span v-else-if="props.type == 'yn'">{{props.value|yesNo}}</span>

    <span v-else-if="['date', 'datetime', 'time'].includes(props.type)">{{ $dtz(props.value, props.type) }}</span>

    <router-link v-else-if="props.type == 'link'" :to="{name: props.params.to, params: {id: props.params.id }}">{{props.value}}</router-link>
</template>

<script>
    export default {
        props: {
            type: {
                type: String,
                required: true
            },
            value: {
                default: null
            },
            params: {
                default: null
            }
        }
    }
</script>
