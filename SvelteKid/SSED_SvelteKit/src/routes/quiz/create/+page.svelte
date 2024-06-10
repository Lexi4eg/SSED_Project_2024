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
	<input type="text" bind:value={question} placeholder="Enter your question" />

	<div>
		{#each answers as answer, i (i)}
			<div class="flex flex-row">
			<input type="text" bind:value={answer.answer} placeholder={`Enter answer ${i + 1}`} />
			<label>
				<input class="bg-blue-800 rounded-xl " type="checkbox" bind:checked={answer.correct} />
				Correct
			</label>
			</div>
		{/each}
	</div>

	<button on:click={handleSubmit}>Create Question</button>
</div>