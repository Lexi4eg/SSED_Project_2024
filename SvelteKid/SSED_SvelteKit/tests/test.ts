import { expect, test } from '@playwright/test';

/*test('about page has expected h1', async ({ page }) => {
	await page.goto('/');
	await expect(page.locator('h1')).toHaveText('Welcome to the SSED Project');
});*/

test('Sind Fragen da?', async ({ page }) => {
	await page.goto('/quiz');
	const response = await fetch('http://localhost:8080/api/v1/questions', {
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