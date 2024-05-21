FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src
COPY ["SWP_Project_2024/SWP_Project_2024.csproj", "SWP_Project_2024/"]
RUN dotnet restore "SWP_Project_2024/SWP_Project_2024.csproj"
COPY . .
WORKDIR "/src/SWP_Project_2024"
RUN dotnet build "SWP_Project_2024.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "SWP_Project_2024.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "SWP_Project_2024.dll"]
