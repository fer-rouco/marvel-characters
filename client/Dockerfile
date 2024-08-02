FROM node:20-slim AS base
ENV PNPM_HOME="/pnpm"
ENV PATH="$PNPM_HOME:$PATH"
RUN corepack enable

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN pnpm install -g @angular/cli

RUN pnpm install

CMD ["ng", "serve", "--host", "0.0.0.0"]