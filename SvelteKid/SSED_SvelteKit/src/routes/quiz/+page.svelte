<script lang="ts">
	import { onMount } from 'svelte';

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

	async function fetchData() {
		const response = await fetch('http://localhost:8080/api/v1/questions', {
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

	let data: Question[] = [];
	let score = 0;
	let username:string = '"';


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



	async function createLeaderboardEntry(username: string, score: number) {
		const response = await fetch('http://localhost:8080/api/v1/leaderboard', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ username, score })
		});

		if (!response.ok) {
			throw new Error(`HTTP error! status: ${response.status}`);
		}

		console.log('Leaderboard entry created');
	}

</script>



<div class="p-4">

	<h2 class="text-xl mb-2">Score: {score}</h2>
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