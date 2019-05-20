<template>

    <div v-if="totalPages > 1" class="slds-pagination slds-grid slds-grid_vertical-align-center">
        <button
            class="slds-button slds-button_icon slds-button_icon-container"
            title="Previous Page"
            @click="currentPage--"
            :disabled="currentPage == 1"
        >
            <icon icon="chevron-left" class="slds-button__icon" />
        </button>

        <div class="slds-p-horizontal--small">
            <div v-if="totalPages <= maxPageListing" class="slds-pagination_pages">
                <a
                    v-for="p in totalPages"
                    :class="[
                        'slds-button',
                        (p == currentPage ? 'slds-button_brand' : 'slds-button_neutral')
                    ]"
                    @click="currentPage = p"
                >
                    {{p}}
                </a>
            </div>

            <div v-else class="slds-pagination_page-selector slds-grid slds-grid_vertical-align-center">
                <span class="slds-text-body_small slds-pagination_page-text slds-m-right_x-small">
                    Page
                </span>
                <input
                    v-model.lazy.number="currentPage"
                    autocomplete="false"
                    class="slds-input"
                />
                <span class="slds-text-body_small slds-pagination_page-text slds-m-left_x-small">
                    of {{totalPages}}
                </span>
            </div>
        </div>

        <button
            class="slds-button slds-button_icon slds-button_icon-container"
            title="Next Page"
            @click="currentPage++"
            :disabled="currentPage == totalPages"
        >
            <icon icon="chevron-right" class="slds-button__icon" />
        </button>
    </div>

</template>

<script>
    export default {

    }
</script>

<style>

</style>
