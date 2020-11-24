<template>
  <v-container>
    <v-card class="elevation-12 mx-auto" max-width="1500">
      <v-toolbar dark color="primary">
        <v-toolbar-title>Create Project</v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-form ref="form" lazy-validation>
          <v-text-field
            id="projectName"
            v-model="form.projectName"
            :counter="25"
            :rules="[(v) => !!v || 'Name is required']"
            label="Name"
            required
          ></v-text-field>

          <v-textarea
            id="projectDescription"
            v-model="form.projectDescription"
            :counter="255"
            :rules="[(v) => !!v || 'Description is required']"
            label="Description"
            required
          ></v-textarea>

          <v-text-field
            id="projectLink"
            v-model="form.projectLink"
            label="Project URL"
          ></v-text-field>

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
  name: "createProject",
  data: () => ({
    form: {
      projectName: "",
      projectDescription: "",
      active: true,
    },
  }),
  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.createProject();
      }
    },
    createProject() {
      return this.$store.dispatch("createProject", this.form);
    },
  },
};
</script>