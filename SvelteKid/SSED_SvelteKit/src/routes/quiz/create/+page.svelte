<script>
	import { createQuestion } from './+server';

	let question = '';
	let answers = [
		{ answer: '', correct: false },
		{ answer: '', correct: false },
		{ answer: '', correct: false },
		{ answer: '', correct: true },
	];

	$: questionObject = {
		id: 14,
		question,
		IsAnswered: null,
		IsCorrect: null,
		answers
	};

	async function handleSubmit() {
		try {
			await createQuestion(questionObject);
			console.log('Question created');
		} catch (error) {
			console.error(error);
		}
	}
</script>

<div>

	<input type="text" class="bg-gray-800 w-full p-4 rounded-md my-2" bind:value={question} placeholder="Enter your question" />

	<div>
		{#each answers as answer, i (i)}
			<div class="flex flex-row">
				<input type="text" class="bg-gray-800 w-full p-4 rounded-md my-2" bind:value={answer.answer} placeholder={`Enter answer ${i + 1}`} />
				<label class="flex justify-center items-center">
					<input class="bg-gray-800 m-5 h-5 w-5 justify-center items-center p-4 rounded-md my-2" type="checkbox" bind:checked={answer.correct} />

				</label>

			</div>
		{/each}
	</div>

	<button class="bg-red-500 w-full p-4 rounded-md my-2" on:click={handleSubmit}>Create Question</button>
</div>