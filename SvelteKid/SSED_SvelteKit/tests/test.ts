import { expect, test } from '@playwright/test';

test('about page has expected h1', async ({ page }) => {
	await page.goto('/');
	await expect(page.locator('div')).toHaveText('Welcome to the SSED Project');
});
