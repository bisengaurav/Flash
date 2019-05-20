<template>
    <span>
        {{duration}}
    </span>
</template>

<script>
    import DateService from '../core/date-service.js';

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: [
            'start',
            'end'
        ],
        computed: {
            duration: function() {
                return DateService.diffBetweenDates(this.start, this.end);
            }
        }

    }
</script>
