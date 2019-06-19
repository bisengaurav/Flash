<template>
    <div>
        <h1 class="slds-text-heading_large slds-m-bottom_large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader type="block" :height="400" :loading="loading" #content>
            <div v-if="data">
                <div v-if="metadata.fields && metadata.fields.length > 0" class="slds-card slds-p-around_medium slds-m-bottom_x-large">
                    <grid>

                        <grid-item
                            v-for="f in metadata.fields"
                            :key="f.field"
                        >
                            <form-element-static :label="$t('entity.'+$props.entity+'.'+f.field+'.label')">

                                <output-field
                                    :type="f.type"
                                    :value="data[f.field]"
                                    :params="{
                                        to: f.to,
                                        id: data[f.id]
                                    }"
                                />

                            </form-element-static>
                        </grid-item>

                    </grid>
                </div>


                <entity-relations
                    v-for="r in metadata.relations"
                    :key="r.entity"
                    :title="$t(r.title)"
                >
                    <data-table-basic :source="data[r.dataField]">

                        <template #head>

                            <th
                                v-for="f in r.fields"
                                :key="f.field"
                                v-t="'entity.'+r.entity+'.'+f.field+'.label'"
                            />

                        </template>
                        <template #row="{row, id}">

                            <td
                                v-for="f in r.fields"
                                :key="f.field"
                            >

                                <output-field
                                    :type="f.type"
                                    :value="row[f.field]"
                                    :params="{
                                        to: f.to,
                                        id: row[f.id]
                                    }"
                                />

                            </td>

                        </template>

                    </data-table-basic>
                </entity-relations>
            </div>
        </loader>

    </div>
</template>

<script>
    import PageInterface from '../../interfaces/page.js';
    import * as Metadata from './metadata.js';

    export default {
        extends: PageInterface,

        //
        // PARAMS: props, data, computed
        //
        props: {
            entity: {
                type: String,
                required: true
            },
            id: {
                type: Number,
                default: null
            }
        },
        data() {
            return  {
                metadata: Metadata[this.$props.entity],
                loading: true,
                data: null
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.loading = true;

                // wrong Job ID
                if (!this.id) {
                    throw new Error('Wrong ID');
                }

                // data
                this.metadata = Metadata[this.$props.entity];
                this.metadata.action(this.id)
                    .then(data => {
                        this.loading = false;
                        this.data = data;

                        this.pageTitle = this.data[this.metadata.title];
                    })
                    .catch(() => {
                        this.loading = false;
                    });
            }
        },

        //
        // WATCHERS
        //
        watch: {
            id: {
                handler() {
                    this.init();
                },
                immediate: true
            }
        }

    }
</script>
