import { expect, test } from '@playwright/test';

test('Ist Leaderboard da?', async ({ page }) => {
	await page.goto('/leaderboard');
	const response = await fetch('http://localhost:8080/api/v1/leaderboard', {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	});

	if (response.status !== 200) {
		throw new Error(`HTTP error! status: ${response.status}`);
	}

	await expect(response != null).toBeTruthy();
});