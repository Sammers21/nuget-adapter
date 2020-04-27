/*
 * MIT License
 *
 * Copyright (c) 2020 Artipie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.artipie.nuget;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link PackageIdentity}.
 *
 * @since 0.1
 */
public class PackageIdentityTest {

    /**
     * Example package identity.
     */
    private final PackageIdentity identity = new PackageIdentity(
        new PackageId("Newtonsoft.Json"),
        new Version("12.0.3")
    );

    @Test
    void shouldGenerateRootKey() {
        MatcherAssert.assertThat(
            this.identity.rootKey().string(),
            Matchers.is("newtonsoft.json/12.0.3")
        );
    }

    @Test
    void shouldGenerateNupkgKey() {
        MatcherAssert.assertThat(
            this.identity.nupkgKey().string(),
            Matchers.is("newtonsoft.json/12.0.3/newtonsoft.json.12.0.3.nupkg")
        );
    }

    @Test
    void shouldGenerateHashKey() {
        MatcherAssert.assertThat(
            this.identity.hashKey().string(),
            Matchers.is("newtonsoft.json/12.0.3/newtonsoft.json.12.0.3.nupkg.sha512")
        );
    }

    @Test
    void shouldGenerateNuspecKey() {
        MatcherAssert.assertThat(
            this.identity.nuspecKey().string(),
            Matchers.is("newtonsoft.json/12.0.3/newtonsoft.json.nuspec")
        );
    }
}
