# ─── Stage 1: Build the Vite app ───────────────────────────
FROM node:20-alpine AS build

# Set working dir
WORKDIR /app

# Copy package manifests and install deps (leverages cache)
COPY package*.json ./
RUN npm ci

# Copy source and build
COPY . .
RUN npm run build

# ─── Stage 2: Serve with nginx ────────────────────────────
FROM nginx:alpine

# Remove default nginx content
RUN rm -rf /usr/share/nginx/html/*

# Copy built files from the build stage
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 80 (Compose or `-p` will map it to your host port)
EXPOSE 80

# Start nginx in foreground
CMD ["nginx", "-g", "daemon off;"]