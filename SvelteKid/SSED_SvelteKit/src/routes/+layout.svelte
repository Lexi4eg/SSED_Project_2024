<script>
	import "../app.css";
</script>
<title>SSED Project</title>
<svelte:head>
	<meta name="description" content="Your description here">
</svelte:head><div class="bg-gray-700 text-white w-full h-full min-h-screen">
	<header class="bg-gray-900 sm:p-4 p-2 w-full">
		<div class="  flex justify-between items-center">
			<h1 class="sm:text-2xl text-xl sm:font-bold"><a href="/">SSED Project</a></h1>
			<nav class="">
				<ul class="flex space-x-4">
					<li>
						<a href="/">Home</a>
					</li>
					<li>
						<a href="/books">Books</a>
					</li>
					<li>
						<a href="/quiz">Quiz</a>
					</li>
					<li>
						<a href="/leaderboard">Leaderboard</a>
					</li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="p-4">
		<slot />
	</div>

</div>