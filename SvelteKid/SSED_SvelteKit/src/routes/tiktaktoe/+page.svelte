<script lang="ts">
	import { type Writable, writable } from 'svelte/store';

	type BoardType = ('X' | 'O' | '')[][];
	type PlayerType = 'X' | 'O';
	type WinnerType = PlayerType | '';
	type ComboType = number[][];

	const board: Writable<BoardType> = writable([
		['', '', ''],
		['', '', ''],
		['', '', '']
	]);

	let player: PlayerType = 'X';
	let winner: WinnerType = '';

	const winningCombos: ComboType[] = [
		[[0, 0], [0, 1], [0, 2]],
		[[1, 0], [1, 1], [1, 2]],
		[[2, 0], [2, 1], [2, 2]],
		[[0, 0], [1, 0], [2, 0]],
		[[0, 1], [1, 1], [2, 1]],
		[[0, 2], [1, 2], [2, 2]],
		[[0, 0], [1, 1], [2, 2]],
		[[0, 2], [1, 1], [2, 0]]
	];

	function handleClick(rowIndex: number, cellIndex: number): void {
		board.update(b => {
			if (b[rowIndex][cellIndex] === '' && !winner) {
				b[rowIndex][cellIndex] = player;
				player = player === 'X' ? 'O' : 'X';
			}
			return b;
		});
	}

	$: {
		let currentBoard: BoardType = $board;
		winningCombos.forEach((combo: ComboType) => {
			const [a, b, c] = combo;
			if (
				currentBoard[a[0]][a[1]] &&
				currentBoard[a[0]][a[1]] === currentBoard[b[0]][b[1]] &&
				currentBoard[a[0]][a[1]] === currentBoard[c[0]][c[1]]
			) {
				winner = player;
			}
		});
	}
</script>

<div class="grid grid-cols-3  gap-4">
	<div class="col-span-2">
		<div class="grid grid-cols-3 gap-4 justify-center items-center ">
			{#each $board as row, rowIndex}
				{#each row as cell, cellIndex}
					<button class="bg-gray-800 w-20 h-20 flex  items-center justify-center rounded-4xl text-white p-4" on:click={() => handleClick(rowIndex, cellIndex)}>{cell}</button>
				{/each}
			{/each}
		</div>
	</div>
	<div>
		<h2>Game Info</h2>
		<p>Player: {player}</p>
		<p>Winner: {winner}</p>
	</div>
</div>