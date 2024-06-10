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
	<h2 class="text-4xl mb-2 flex justify-center  ">Score: {score}</h2>
	<div class="flex flex-col items-center justify-center ">
		<input type="text" bind:value={username} placeholder="Enter your username" class="sm:w-44 p-2 mb-4 bg-gray-800 flex rounded-md justify-center  text-white"  />
	</div>

	{#each data as question (question.id)}
		<div class=" flex justify-center flex-col p-4 items-center">
			<h2 class="text-2xl p-2">{question.question}</h2>
			<div class="grid grid-cols-2 grid-rows-2  sm:w-96 w-54">
				{#each question.answers as answer (answer.id)}
					<div class="w-full flex items-center text-xl justify-center">
						<button
							class="btn sm:w-40 sm:h-28 h-28 w-28   m-2 rounded  {question.isAnswered ? (answer.correct ? 'bg-green-500' : 'bg-red-500') : 'bg-blue-500'}"
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
	<div class="flex justify-center  ">
			<button class="btn w-40 h-12 items-center text-xl m-2 rounded bg-red-700 justify-center flex" on:click={finishQuiz} disabled={!data.every(question => question.isAnswered)|| username.length === 0 }>Finish</button>
	</div>
</div>