export interface DataItem {
	id: number;
	username: string;
	score: number;
}

export async function fetchData(): Promise<DataItem[]> {
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