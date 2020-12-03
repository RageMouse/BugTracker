<template>
  <v-dialog v-model="show" max-width="500px">
    <v-card>
      <v-img
        class="white--text align-end mt-4"
        height="100px"
        src="https://picsum.photos/800"
      >
      </v-img>
        <v-card-title class="headline">
          Are you sure?
        </v-card-title>
        <v-card-text>This is an irreversible action, which you might regret for the rest of your life. You'll think back to this moment in time when you had to click 'Disagree' but you didn't.</v-card-text>
      <v-card-actions>
          <v-spacer></v-spacer>
        <v-btn color="error" text @click.stop="show = false">
          Disagree
        </v-btn>
        <v-btn color="primary" text @click="deleteProject" @click.stop="show = false">
          Agree
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: ["visible"],
  data() {
    return {
      dialog: false,
    };
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
        this.deleteProject();
      }
    },
    deleteProject() {
      return this.$store.dispatch("deleteProject", this.$route.params.id);
    }
  },
};
</script>