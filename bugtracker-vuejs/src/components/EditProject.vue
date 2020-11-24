<template>
  <v-dialog v-model="show" max-width="500px">
    <v-card>
      <v-img
        class="white--text align-end mt-4"
        height="100px"
        src="https://picsum.photos/800"
      >
        <v-card-title>Edit Project: {{ project.projectId }}</v-card-title>
      </v-img>
      <v-card-text>
        <v-form ref="form" lazy-validation>
          <v-text-field
            id="projectName"
            v-model="form.projectName"
            :placeholder="project.projectName"
            :counter="25"
            :rules="nameRules"
            label="Name"
            required
          ></v-text-field>

          <v-textarea
            id="projectDescription"
            v-model="form.projectDescription"
            :placeholder="project.projectDescription"
            :counter="255"
            :rules="[(v) => !!v || 'Description is required']"
            label="Description"
            required
          ></v-textarea>
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn color="primary" @click="validate">Update</v-btn>
        <v-btn color="primary" @click.stop="show = false">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: ["visible"],
  data: () => ({
    form: {
      projectId: "",
      projectName: "",
      projectDescription: "",
    },
    nameRules: [
      (v) => !!v || "Name is required",
      (v) => (v && v.length <= 25) || "Name must be less than 25 characters",
    ],
  }),
  mounted() {
    this.getProject();
  },
  computed: {
    show: {
      get() {
        return this.visible;
      },
      set(value) {
        if (!value) {
          this.$emit("close");
        }
      },
    },
    project() {
      return this.$store.getters.project;
    },
  },
  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.editProject();
      }
    },
    editProject() {
      this.form.projectId = this.project.projectId;
      return this.$store.dispatch("editProject", this.form);
    },
    getProject() {
      return this.$store.dispatch("getProject", this.$route.params.id);
    },
  },
};
</script>