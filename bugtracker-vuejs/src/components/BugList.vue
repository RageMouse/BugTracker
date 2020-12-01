<template>
  <v-card max-width="1250" class="mx-auto">
    <v-subheader>Bug List</v-subheader>
    <v-list three-line>
      <template v-for="bug in bugs">
        <v-divider
        inset
          :key="bug.bugId"
        ></v-divider>

        <v-list-item :key="bug.bugTitle">
          <v-list-item-avatar>
            <v-img src="https://cdn.discordapp.com/avatars/98846273649508352/6b543b96447b5a6e1bb003c143b86d3e.png?size=128"></v-img>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-html="bug.bugTitle"></v-list-item-title>
            <v-list-item-subtitle v-html="bug.bugDescription"></v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
  </v-card>
</template>


<script>
export default {
  name: "bugList",
  computed: {
    bugs() {
      return this.$store.getters.bugs;
    },
  },
  mounted() {
    this.getBugs();
  },
  methods: {
    getBugs() {
      return this.$store.dispatch("getBugs", this.$route.params.id);
    },
  },
};
</script>