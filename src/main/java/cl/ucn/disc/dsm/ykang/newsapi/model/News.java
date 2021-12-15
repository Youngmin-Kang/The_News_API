/*
 * Copyright 2021 Youngmin Kang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.ykang.newsapi.model;

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import lombok.Getter;

import javax.persistence.*;

/**
 * The News class.
 *
 * @author Youngmin Knag.
 */
@Entity
public final class News {

    /**
     * Primary Key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long Key;

    /**
     * ID unique.
     */
    // @Column(unique = true)
    @Getter
    private Long id;

    /**
     * The Title.
     */
    @Getter
    private String title;

    /**
     * The Source.
     */
    @Getter
    private String source;

    /**
     * The Author.
     */
    @Getter
    private String author;

    /**
     * The Url.
     */
    @Getter
    private String url;

    /**
     * The Url Image.
     */
    @Getter
    private String urlImage;

    /**
     * The Description.
     */
    @Getter
    private String description;

    /**
     * The Content.
     */
    @Getter
    private String content;

    /**
     * The date og publish.
     */
    @Getter
    private ZonedDateTime publishedAt;
    /**
     * JPA required!
     */
    public News() {
        // Noting here
    }

    /**
     * The Constructir of News.
     *
     * @param title       can't be null.
     * @param source      can't be null.
     * @param author      can't be null.
     * @param url         can be null.
     * @param urlImage    can be null.
     * @param description can't be null.
     * @param content     can't be null.
     * @param publishedAt can't be null.
     */

    public News(final String title,
                final String source,
                final String author,
                final String url,
                final String urlImage,
                final String description,
                final String content,
                final ZonedDateTime publishedAt) {

        // Title
        if (title == null || title.length() < 2) {
            throw new IllegalArgumentException("Title required");
        }
        this.title = title;

        // Source
        if (source == null || source.length() < 2) {
            throw new IllegalArgumentException("Source required");
        }
        this.source = source;

        // Author
        if (author == null || author.length() < 3) {
            throw new IllegalArgumentException("Author required");
        }
        this.author = author;

        //ID: Hashing(title + | + source + | + author)
        this.id = LongHashFunction.xx().hashChars(title + "|" + source + "|" + author);

        this.url = url;
        this.urlImage = urlImage;

        // Description
        if (description == null || description.length() < 4) {
            throw new IllegalArgumentException("Description required");
        }
        this.description = description;

        //Content
        if (content == null || content.length() < 2) {
            throw new IllegalArgumentException("Content required");
        }
        this.content = content;

        //PublishedAt
        if (publishedAt == null) {
            throw new IllegalArgumentException("Published At required");
        }
        this.publishedAt = publishedAt;
    }
}
