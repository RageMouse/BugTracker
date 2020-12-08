<template>
  <v-container>
    <v-card class="elevation-12 mx-auto" max-width="1500">
      <v-toolbar dark color="primary">
        <v-toolbar-title>Submit Bug</v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-form ref="form" lazy-validation>
          <v-text-field
            id="bugTitle"
            v-model="form.bugTitle"
            :counter="25"
            :rules="[(v) => !!v || 'Name is required']"
            label="Name"
            required
          ></v-text-field>

          <v-textarea
            id="bugDescription"
            v-model="form.bugDescription"
            :counter="255"
            :rules="[(v) => !!v || 'Description is required']"
            label="Description"
            required
          ></v-textarea>

          <v-btn
            id="validateButton"
            color="success"
            class="mr-4"
            @click="validate"
            >Validate</v-btn
          >
        </v-form>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "submitBug",
  data: () => ({
    form: {
      bugTitle: "",
      bugDescription: "",
      solved: false,
      projectId: "",
    },
  }),
  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.submitBug();
        this.reset();
      }
    },
    submitBug() {
      this.form.projectId = this.$route.params.id;
      return this.$store.dispatch("submitBug", this.form);
    },
    reset() {
      this.$refs.form.reset();
    },
  },
};
</script>