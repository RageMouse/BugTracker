<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12"></v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">
          Here are all the current projects.
        </h1>

        <v-banner class="subheading font-weight-regular">
          Where projects comes to die.
        </v-banner>
        <v-col  >
        <v-btn id="createProject" depressed small color="primary" @click="toggleCreateProject">Create Project</v-btn>
        </v-col>
        <CreateProject v-if="showCreateProject"/>
        <Projects/>
      </v-col>
    </v-row>
    <v-row> </v-row>
  </v-container>
</template>

<script>
import Projects from '@/components/Projects.vue'
import CreateProject from '@/components/CreateProject.vue'

export default {
  name: "Project",
  components: {
    Projects,
    CreateProject
  },
  data: () => ({
    showCreateProject: false
  }),
  methods: {
    toggleCreateProject () {
      this.showCreateProject = !this.showCreateProject;
    }
  }
};
</script>
