<script lang="ts">
	import { onMount } from 'svelte';

	interface Book {
		id: number;
		title: string;
		author: string;
		genre: string;
		year: number;
		isbn: string;
		description: string;
		image: string;
	}


	async function fetchData() {
		const response = await fetch('http://localhost:8080/api/v1/leaderboard', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (!response.ok) {
			throw new Error(`HTTP error! status: ${response.status}`);
		}

		return response.json();
	}

	let data: Book[] = [];

	onMount(async () => {
		try {
			data = await fetchData();
		} catch (error) {
			console.error(error);
		}
	});


</script>


<h1>Books</h1>
<meta name="viewport" content="width=device-width, initial-scale=1">

<table class="min-w-full divide-y divide-gray-600">
	<thead class="bg-gray-800">
	<tr>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Title
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Author
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Genre
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Year
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			ISBN
		</th>
		<th class="px-6 py-3 text-left text-xs font-medium text-gray-200 uppercase tracking-wider">
			Description
		</th>
	</tr>
	</thead>
	<tbody class="bg-gray-900 divide-y divide-gray-700">
	{#each data as item, index (item.id)}
		<tr>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{index + 1}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.title}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.author}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.genre}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.year}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.isbn}</div>
			</td>
			<td class="px-6 py-4 whitespace-nowrap">
				<div class="text-sm text-gray-300">{item.description}</div>
			</td>
		</tr>
	{/each}
	</tbody>
</table>

