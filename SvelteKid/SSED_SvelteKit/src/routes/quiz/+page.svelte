<script lang="ts">
	import { onMount } from 'svelte';
	import { createLeaderboardEntry, fetchData } from './+server';

	interface Answer {
		id: number;
		answer: string;
		correct: boolean;
	}
	interface Question {
		id: number;
		question: string;
		isAnswered: boolean;
		isCorrect: boolean;
		answers: Answer[];
	}


	let data: Question[] = [];
	let score = 0;
	let username = '';

	onMount(async () => {
		try {
			data = await fetchData();
		} catch (error) {
			console.error(error);
		}
	});

	function selectAnswer(question: Question, answer: Answer) {
		if (question.isAnswered) {
			return;
		}

		question.isAnswered = true;
		question.isCorrect = answer.correct;

		if (answer.correct) {
			score += 1;
		}

		console.log(`Answer is ${answer.correct ? 'correct' : 'incorrect'}`);

		data = [...data];
	}

	async function finishQuiz() {
		try {
			await createLeaderboardEntry(username, score);
			console.log('Quiz finished and leaderboard entry created');
		} catch (error) {
			console.error(error);
		}
		location.reload();
	}


</script>




<div class="p-4">
	<h2 class="text-xl mb-2">Score: {score}</h2>
	<div class="flex flex-col justify-between ">
		<input type="text" bind:value={username} placeholder="Enter your username" class="w-44 p-2 mb-4 bg-gray-800 rounded-md  text-white"  />
		<button class="btn w-20 m-2 rounded bg-blue-500" on:click={finishQuiz} disabled={!data.every(question => question.isAnswered)}>Finish</button>
	</div>

	{#each data as question (question.id)}
		<div class="mb-4 flex justify-center flex-col items-center">
			<h2 class="text-xl mb-2">{question.question}</h2>
			<div class="grid grid-cols-2 grid-rows-2  w-44">
				{#each question.answers as answer (answer.id)}
					<div class=" w-10 ">
						<button
							class="btn w-20 m-2 rounded  {question.isAnswered ? (answer.correct ? 'bg-green-500' : 'bg-red-500') : 'bg-blue-500'}"
							on:click={() => selectAnswer(question, answer)}
							disabled={question.isAnswered}
						>
							{answer.answer}
						</button>
					</div>
				{/each}
			</div>
		</div>
	{/each}
</div>