# Stage 1: Build Vite project
FROM node:20-alpine AS build

WORKDIR /app
COPY . .

RUN npm install
RUN npm run build

# Stage 2: Serve with nginx
FROM nginx:alpine

# Copy built frontend from previous stage
COPY --from=build /app/dist /usr/share/nginx/html

# Copy custom nginx config if needed
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
