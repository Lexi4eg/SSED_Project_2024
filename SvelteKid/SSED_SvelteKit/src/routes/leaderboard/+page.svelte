<script lang="ts">
	import { onMount } from 'svelte';
	import { fetchData } from './api';

	interface DataItem {
		id: number;
		username: string;
		score: number;
	}

	let data: DataItem[] = [];

	onMount(async () => {
		try {
			data = await fetchData();
			data.sort((a, b) => b.score - a.score);
			console.log(data);
		} catch (error) {
			console.error(error);
		}
	});
</script>


<meta name="viewport" content="width=device-width, initial-scale=1">
<table class="min-w-full divide-y divide-gray-600">
	<thead class="bg-gray-800">
	<tr>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Rank
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Username
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Score
		</th>
	</tr>
	</thead>
	<tbody class="bg-gray-900 divide-y divide-gray-700">
	{#each data as item, index (item.id)}
		<tr>
			<td class="px-6 py-6 whitespace-nowrap">
				<div class="text-sm text-gray-300">{index + 1}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.username}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.score}</div>
			</td>
		</tr>
	{/each}
	</tbody>
</table>


