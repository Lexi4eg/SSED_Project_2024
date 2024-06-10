export async function createQuestion(questionObject: any) {
	const response = await fetch('http://localhost:8080/api/v1/questions', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(questionObject)
	});

	if (!response.ok) {
		throw new Error(`HTTP error! status: ${response.status}`);
	}

	console.log('Question created');
}