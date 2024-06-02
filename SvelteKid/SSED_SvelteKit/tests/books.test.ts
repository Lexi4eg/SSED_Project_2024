import { test, expect, type Page } from '@playwright/test';

test('books page has expected h1', async ({ page }) => {
	await page.goto('/books');
	await expect(page.locator('h1')).toHaveText('Books');
});