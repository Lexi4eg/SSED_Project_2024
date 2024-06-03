export  async function createLeaderboardEntry(username: string, score: number) {
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


export async function fetchData() {
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