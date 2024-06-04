<script setup lang="ts">

interface Leaderboard {
  id: number
  username : string
  score: number
}
const { data } = await useFetch<Leaderboard[]>('http://localhost:8080/api/v1/leaderboard')

</script>

<template>
  <div class="p-2">
    <h1 class="text-3xl ">Leaderboard</h1>
    <UTable  :rows="data || []" />
  </div>
</template>