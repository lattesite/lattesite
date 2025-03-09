# LatteSite - An all-in-one SEO-focused, lightweight static site generator framework in Java

LatteSite is an [SEO (Search Engine Optimization)](https://en.wikipedia.org/wiki/Search_engine_optimization) focused,
lightweight [SSG (Static Site Generator)](https://en.wikipedia.org/wiki/Static_site_generator) framework that
uses [OOP (Object-Oriented Programming)](https://en.wikipedia.org/wiki/Object-oriented_programming) principles,
written in [Java](https://en.wikipedia.org/wiki/Java_(programming_language)).

## Official website

Please visit the official website for more details:

- https://www.lattesite.se

## Demo repositories

The website www.lattesite.se is built using this generator.

Full source code can be found here:

- https://github.com/lattesite/www-lattesite-se

## Why this project got created

LatteSite was created to eliminate the need for combining multiple frameworks and languages just to build a
blazing fast static website capable of achieving a 100% [Google Lighthouse](https://en.wikipedia.org/wiki/Lighthouse_(software)) score.

The framework is built on Java — one of the most popular and versatile backend languages — providing a single,
unified solution for generating high-performance static sites.

## Site generation features

- Generate HTML (HyperText Markup Language) based on POJO (Plain Old Java Objects)
- Sitemap generator
- Structured Data support
- Google Merchant Feed (XML (eXtensible Markup Language)) support
- Maintains a public/ and static/ folder structure
- Localization support
- A built-in basic CSS (Cascading Style Sheets) framework
- A built-in static web server for local development

## This project is very young

This is a newly created project, so it lacks a lot of common features, as well as a structure and ways of working.

However, these can be defined and established if the project grows in popularity.

## Principles

- Lightweight framework with not a lot of moving parts
- SOLID (Single Responsibility, Open-Closed, Liskov Substitution, Interface Segregation, Dependency Inversion)
- KIS (Keep It Simple) and POJO (Plain Old Java Objects)
- Object-Oriented Programming style
- Services and utilities using Dependency Injection patterns
- A single exported JAR (Java Archive) artifact

## Architectural overview

The framework currently consists of these main features:

- HTML Elements & Custom Composite Components

  There is a POJO for each common [HTML element](https://developer.mozilla.org/en-US/docs/Web/HTML/Element).

  Custom composite components can be built on top of these elements to form a reusable component library.

- HTML Generator

  A default HTML generator is included that can be used, extended, or replaced with a custom implementation.

- Sitemap Generator

  A default sitemap.xml generator is included that can be used out of the box.

- Pages and Page Generator

  A standard HTML Page abstraction is provided that can be used, extended, or replaced with a custom implementation.

  A default Page HTML generator is also included that can be used, extended, or replaced.

- i18n (Internationalization) Localization

  The framework supports websites using multiple locales.

- Static Web Server

  A built-in HTTP (HyperText Transfer Protocol) server is included for serving the generated site locally during development.

## Source code examples

- [online-christoffer-www](https://github.com/corgrath/online-christoffer-www/blob/master/src/online/christoffer/www/Main.java)

## What about JavaScript?

At the current time, there is no official way to implement JavaScript.

This means that for the time being any JavaScript framework can be used alongside LatteSite.

## Getting started

- TBA (To Be Announced)

## Releases & Distribution

- New JAR artifact releases may be published at any time, meaning there are no defined milestones.
- Versioning is based on [Date of Release](https://en.wikipedia.org/wiki/Software_versioning#Date_of_release)
  using the [ISO 8601 Date Format](https://en.wikipedia.org/wiki/ISO_8601), for example `lattesite-20250101`
- Compiled JAR artifacts for this module are available in the `/releases/` directory of this repository.

## Development process

The project owner controls the development of the project, including adding/rejecting contributions.

There are no defined commit message conventions at this time.

## Project Information

- License - See LICENSE.md for details (Apache License 2.0)
- Notice - See NOTICE.md for attribution and legal notices
- Contributing - See CONTRIBUTING.md for guidelines
